import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/book';
import { BookEdit } from '../model/book-edit';
import { BookDetails } from '../model/book-detail';
import { BookAdd } from '../model/book-add';

@Injectable()
export class BooksService {

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>('/api/books');
  }

  getBook(uuid: string): Observable<BookDetails> {
    return this.http.get<BookDetails>('/api/books/' + uuid);
  }

  addBook(request: BookAdd): Observable<any> {
    console.log(request);
    return this.http.post<any>('/api/books', request);
  }

  deleteBook(uuid: string): Observable<any> {
    return this.http.delete('/api/books/' + uuid);
  }

  putBook(uuid: string, request: BookEdit): Observable<any> {
    return this.http.put('/api/books/' + uuid, request);
  }
}
