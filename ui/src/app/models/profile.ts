export class Profile {
    userId: number;
    address: string;
    phone: number;

    constructor(address: string, phone: number) {
        this.address = address;
        this.phone = phone;
    }
}