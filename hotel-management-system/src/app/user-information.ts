export class User {
    constructor(
        public id: number,
        public name: string,
        public email: string,
        public contactNumber: string,
        public password: string,
        public nationality: string,
        public address: string,
        public type: string,
    ) { }
}
