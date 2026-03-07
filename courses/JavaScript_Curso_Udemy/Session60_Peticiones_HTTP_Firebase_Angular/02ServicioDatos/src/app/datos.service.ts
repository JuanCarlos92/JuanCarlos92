import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DatosService {
  url = 'https://tienda-online-e7015-default-rtdb.firebaseio.com/';

  constructor(private httpClient: HttpClient){}

}
