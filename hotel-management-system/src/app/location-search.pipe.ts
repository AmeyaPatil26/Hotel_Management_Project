import { Pipe, PipeTransform } from '@angular/core';
import { Hotel } from './hotel-information';

@Pipe({
  name: 'locationSearch'
})
export class LocationSearchPipe implements PipeTransform {

  transform(hotels: Hotel[], search: string): Hotel[] {
    if (search === undefined) {
      return hotels;
    } else {
      return hotels.filter(hotel => {
        return hotel.hotelAddress.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}
