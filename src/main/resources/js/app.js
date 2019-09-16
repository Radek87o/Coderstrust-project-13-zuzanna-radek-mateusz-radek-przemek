'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
const axios = require('axios');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {invoices: []};
        this.updateInvoices = this.updateInvoices.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/invoices'}).done(response => {
            this.setState({invoices: response.entity});
        });
    }

    updateInvoices(data) {
        this.setState({invoices: data})
    }

    render() {
        return [
            <div className="container-fluid">
                 <div className="row">
                    <div className="col-md-4">
                        <InvoiceByIssuedDate update={this.updateInvoices}/>
                    </div>
                 </div>
                 ,
                 <div className="row">
                    <div className="col-md-12">
                        <InvoiceList invoices={this.state.invoices}/>
                    </div>
                 </div>
            </div>
        ]
    }
}

class InvoiceList extends React.Component{
    render() {
        const invoices = this.props.invoices.map(i =>
            <Invoice key={i.id} invoice={i} update={this.updateInvoices}/>
        );
        return (
            <table className="table table-bordered table-hover">
                <tbody>
                <tr className="table-info">
                    <th scope="col">Number</th>
                    <th scope="col">Issue date</th>
                    <th scope="col">Seller</th>
                    <th scope="col">Buyer</th>
                    <th scope="col">Actions</th>
                </tr>
                {invoices}
                </tbody>
            </table>
        )
    }
}

class DeleteButton extends React.Component{
    deleteInvoice(id) {
        axios.delete('/invoices/' + id, {
        }).then(response => {
            client({method: 'GET', path: '/invoices'}).done(response => {
                        this.props.update(response.entity);
                    });
            $.notify("Invoice deleted.", "success");
        }).catch(function (error) {
            $.notify("An error occurred during deleting invoice.", "error");
        });
    }

    render() {
        return(
            <button type="button" class="btn btn-danger" onClick={() => {if (window.confirm('Are you sure you want to delete this invoice?')) this.deleteInvoice(this.props.invoiceId)}}>Delete</button>
        )
    }
}

class PdfButton extends React.Component{
    getPdf(id) {
        axios.get('/invoices/' + id, {
            responseType: 'arraybuffer',
            headers: {'Accept': 'application/pdf'}
        }).then(response => {
            const blob = new Blob([response.data], {type: 'application/pdf'});
            const url = URL.createObjectURL(blob);
            let link = document.createElement('a');
            link.href = url;
            link.download = 'Invoice.pdf';
            link.click();
            $.notify("Pdf file has been downloaded.", "success");
        }).catch(function (error) {
            $.notify("An error occurred during downloading pdf file.", "error");
        });
    }

    render() {
        return(
            <button type="button" class="btn btn-success" onClick={() => this.getPdf(this.props.invoiceId)}>Pdf</button>
        )
    }
}

class InvoiceByIssuedDate extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            startDate: '',
            endDate: ''
        };
    }

    updateStartDate(passedStartDate){
        this.setState({
            startDate: passedStartDate.target.value
        });
    }

    updateEndDate(passedEndDate){
        this.setState({
            endDate: passedEndDate.target.value
        });
    }

    searchByIssuedDate(startDate, endDate) {
        if(startDate == '' || endDate == ''){
            $.notify("Start date or end date cannot be empty", "error");
        } else {
            axios.get('/invoices/byIssuedDate?startDate='+startDate+'&endDate='+endDate, {
            }).then(response => {
                $.notify("Invoices filtered.", "success");
                this.props.update([response.data]);
            }).catch(function (error) {
                if(error.response.status == 400){
                    $.notify("Incorrect issued dates", "error")
                } else {
                    $.notify("An error occurred during searching invoice by issued date.", "error")
                }
            });
        }
    }

    clear() {
        client({method: 'GET', path: '/invoices'}).done(response => {
            this.props.update(response.entity);
            $.notify("Search results cleared.", "success");
        });
    }

    render() {

            return(
                <div className="input-group">
                    <input type="text" className="form-control" placeholder="Start date" value={this.state.startDate} onChange={value => this.updateStartDate(value)}/>
                    <input type="text" className="form-control" placeholder="End date" value={this.state.endDate} onChange={value => this.updateEndDate(value)}/>
                    <div className="input-group-append" id="button-addon4">
                        <button className="btn btn-success btn-outline-secondary" type="button" update={this.updateInvoices} onClick={() => this.searchByIssuedDate(this.state.startDate, this.state.endDate)}>Search</button>
                        <button className="btn btn-error btn-outline-secondary" type="button" update={this.updateInvoices} onClick={() => this.clear()}>Clear</button>
                    </div>
                 </div>
            )
    }
}

class Invoice extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.invoice.number}</td>
                <td>{this.props.invoice.issuedDate}</td>
                <td>{this.props.invoice.seller.name}</td>
                <td>{this.props.invoice.buyer.name}</td>
                <td>
                    <DeleteButton invoiceId={this.props.invoice.id} update={this.props.update} />
                    {' '}
                    <PdfButton invoiceId={this.props.invoice.id} />
                 </td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)
