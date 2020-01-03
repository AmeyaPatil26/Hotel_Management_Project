export class Booking {
    constructor(
        public bookingId: number,
        public bookingAmount: number,
        public roomType: string,
        public roomCapacity: number,
        public email: string,
        public name: string,
        public address: string,
        public contactNumber: string,
        public nationality: string,
        public licenceNumber: string,
        public hotelName: string,
        public checkInDate: Date,
        public checkOutDate: Date
    ) { }
} 
