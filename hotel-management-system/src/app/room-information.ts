export class Room {
    constructor(
        public roomId: number,
        public hotelId: number,
        public licenceNumber: string,
        public hotelName: string,
        public roomCount: number,
        public roomType: string,
        public roomCapacity: string,
        public roomAmount: number,
        public roomStatus: string,
        public roomImageURL: string
    ) { }
}
