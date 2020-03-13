import { IBusStops } from 'app/shared/model/bus-stops.model';

export interface IBusRoute {
  id?: number;
  routeName?: string;
  routeDriver?: string;
  busNumber?: number;
  year?: number;
  status?: string;
  comments?: string;
  busStops?: IBusStops[];
}

export class BusRoute implements IBusRoute {
  constructor(
    public id?: number,
    public routeName?: string,
    public routeDriver?: string,
    public busNumber?: number,
    public year?: number,
    public status?: string,
    public comments?: string,
    public busStops?: IBusStops[]
  ) {}
}
