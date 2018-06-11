import {Component, OnInit} from '@angular/core';
import {GameService} from '../service/gameService';
import {Message} from '../models/message';
import {Score} from '../models/score';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  message: Message;
  score: Score;

  constructor(private gameService: GameService) {
  }

  ngOnInit() {
  }

  play(card: string) {
    this.gameService.Play(card).subscribe(data => {
      if (data != null) {
        this.message = data;
      }
    });
    this.gameService.getScore().subscribe(data => {
      if (data != null) {
        this.score = data;
        console.log(data);
      }
    });
  }

}
