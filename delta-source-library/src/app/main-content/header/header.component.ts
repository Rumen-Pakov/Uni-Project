import {Component, OnInit} from '@angular/core';
import {SharedInfo} from "../../shared/sharedInfo";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public sharedInfo: SharedInfo) {
  }

  ngOnInit(): void {
  }
}
