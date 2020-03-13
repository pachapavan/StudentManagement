import { IStudent } from 'app/shared/model/student.model';
import { IBusRoute } from 'app/shared/model/bus-route.model';

export interface IBusStops {
  id?: number;
  routeName?: string;
  busStops?: string;
  busRouteNames?: IStudent[];
  busRoute?: IBusRoute;
}

export class BusStops implements IBusStops {
  constructor(
    public id?: number,
    public routeName?: string,
    public busStops?: string,
    public busRouteNames?: IStudent[],
    public busRoute?: IBusRoute
  ) {}
}
