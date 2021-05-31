import {Component} from '@angular/core';
import {SharedInfo} from "../shared/sharedInfo";

@Component({
  selector: 'app-main-content',
  templateUrl: './main-content.component.html',
  styleUrls: ['./main-content.component.css']
})
export class MainContentComponent {

  constructor(public sharedInfo: SharedInfo) {
  }
}
