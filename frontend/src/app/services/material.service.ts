import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Material} from '../models/interfaces/material';

@Injectable({ providedIn: 'root' })
export class MaterialService {
  private baseUrl = 'http://localhost:8080/api/materials';

  constructor(private http: HttpClient) {}

  getMaterials(): Observable<Material[]> {
    return this.http.get<Material[]>(this.baseUrl);
  }
}

