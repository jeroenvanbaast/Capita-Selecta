import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { GameComponent } from './game/game.component';
import {GameService} from './service/gameService';

const appRoutes: Routes = [
  {path: 'game', component: GameComponent},
  {
    path: '',
    redirectTo: '/game',
    pathMatch: 'full'
  },
  {path: '**', component: GameComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    GameComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: false} // <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule
  ],
  providers: [GameService],
  bootstrap: [AppComponent]
})
export class AppModule { }
