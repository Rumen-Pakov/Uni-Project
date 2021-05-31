import {AfterViewInit, Component, OnInit} from '@angular/core';
import {SharedInfo} from "../../shared/sharedInfo";
import {Book} from "../../shared/Book";
import {BooksHttp} from "../../shared/BooksHttp";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent {

  constructor(public sharedInfo: SharedInfo, public http: BooksHttp) {
  }
}
