import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BookCardComponent} from './book-card/book-card.component';
import {MainContentComponent} from './main-content/main-content.component';
import {LeftSidebarComponent} from './left-sidebar/left-sidebar.component';
import {HeaderComponent} from './main-content/header/header.component';
import {RightSidebarComponent} from './right-sidebar/right-sidebar.component';
import { BooksComponent } from './main-content/books/books.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    BookCardComponent,
    MainContentComponent,
    LeftSidebarComponent,
    HeaderComponent,
    RightSidebarComponent,
    BooksComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule {
}
