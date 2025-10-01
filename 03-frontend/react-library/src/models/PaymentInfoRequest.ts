class PaymentInfoRequest {
    amount: number;
    currency: string;
    receiptEmail?: string;

    constructor(amount: number, currency: string ) {
        this.amount = amount;
        this.currency = currency;
    }
}

export default PaymentInfoRequest;