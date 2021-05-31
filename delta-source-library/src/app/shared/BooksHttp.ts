import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Book} from "./Book";

@Injectable({providedIn: 'root'})
export class BooksHttp {
  constructor(private http: HttpClient) {

  }

  getBooks() {
    return this.http.get<Book[]>('http://localhost:8080/books/paper-book/all');
  }
}
