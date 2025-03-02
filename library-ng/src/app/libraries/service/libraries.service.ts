import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Library } from '../model/library';
import { LibraryEdit } from '../model/library-edit';
import { LibraryDetails } from '../model/library-detail';
import { Book } from '../../books/model/book';

@Injectable()
export class LibrariesService {

  constructor(private http: HttpClient) { }

  getLibraries(): Observable<Library[]> {
    return this.http.get<Library[]>('/api/libraries');
  }

  getLibrary(uuid: string): Observable<LibraryDetails> {
    return this.http.get<LibraryDetails>('/api/libraries/' + uuid);
  }

  addLibrary(request: LibraryEdit): Observable<any> {
    console.log(request);
    return this.http.post<any>('/api/libraries', request);
  }

  deleteLibrary(uuid: string): Observable<any> {
    return this.http.delete('/api/libraries/' + uuid);
  }

  putLibrary(uuid: string, request: LibraryEdit): Observable<any> {
    return this.http.put('/api/libraries/' + uuid, request);
  }

  getBooksInLibrary(uuid: string): Observable<Book[]> {
    return this.http.get<Book[]>('/api/libraries/' + uuid + '/books');
  }

}
