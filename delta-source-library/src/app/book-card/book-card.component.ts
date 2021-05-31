import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.css']
})
export class BookCardComponent implements OnInit {
  @Input() imgUrl: string = '';
  @Input() heading: string = '';
  @Input() summary: string = '';
  @Output() readMoreClick = new EventEmitter<{ imgUrl: string, heading: string, summary: string }>()

  constructor() {
  }

  ngOnInit(): void {
  }

  readMoreClicked() {
    this.readMoreClick.emit({imgUrl: this.imgUrl, heading: this.heading, summary: this.summary});
  }
}
