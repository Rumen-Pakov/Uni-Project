import {Injectable} from '@angular/core';
import {BooksHttp} from "./BooksHttp";
import {Book} from "./Book";

@Injectable({providedIn: 'root'})
export class SharedInfo{
  fetchedBooks: Book[] = [];
  rightSideBarToggle = true;
  items: number[] = [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 5, 5];
  title = 'delta-source-library';
  selected: {title: string, shortSummary: string, imgUrl: string} = {
    title: '',
    shortSummary: '',
    imgUrl: ''
  }

  constructor(public http: BooksHttp) {
    http.getBooks()
      .subscribe(data => this.fetchedBooks = data)
  }

  togglePopUp() {
    if (!(this.selected.imgUrl.trim().length === 0)) {
      this.rightSideBarToggle = !this.rightSideBarToggle;
    }
  }

  readMoreClicked(book: Book) {
    this.selected.title = book.book.title;
    this.selected.imgUrl = book.book.imgUrl;
    this.selected.shortSummary = book.book.shortSummary;
    if (this.rightSideBarToggle) {
      this.rightSideBarToggle = !this.rightSideBarToggle;
    }
  }
}
