import {Component, OnInit} from '@angular/core';
import {Book} from "../shared/Book";
import {SharedInfo} from "../shared/sharedInfo";

@Component({
  selector: 'app-left-sidebar',
  templateUrl: './left-sidebar.component.html',
  styleUrls: ['./left-sidebar.component.css']
})
export class LeftSidebarComponent {

  constructor(public sharedInfo: SharedInfo) {
  }

}
