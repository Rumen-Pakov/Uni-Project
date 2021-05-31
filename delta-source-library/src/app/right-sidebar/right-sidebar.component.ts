import {Component, OnInit} from '@angular/core';
import {SharedInfo} from "../shared/sharedInfo";

@Component({
  selector: 'app-right-sidebar',
  templateUrl: './right-sidebar.component.html',
  styleUrls: ['./right-sidebar.component.css']
})
export class RightSidebarComponent implements OnInit {

  constructor(public sharedInfo: SharedInfo) {
  }

  ngOnInit(): void {
  }

}
