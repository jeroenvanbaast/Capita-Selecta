import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Message} from '../models/message';
import {Score} from '../models/score';

@Injectable()
export class GameService {
  url = 'http://localhost:8082/api/play/';
  urlStats = 'http://localhost:8083/api/statistics';

  constructor(private http: HttpClient) {
  }

  Play(card: string): Observable<Message> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const params = new HttpParams()
      .set('card', card);
    const options = {
      headers,
      params
    };
    return this.http.post<Message>(this.url, null, options);
  }

  getScore(): Observable<Score> {
    return this.http.get<Score>(this.urlStats);
  }

}
