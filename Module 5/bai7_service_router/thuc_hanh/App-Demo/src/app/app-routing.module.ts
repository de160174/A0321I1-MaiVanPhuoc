import { NgModule } from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';
import {TimelinesComponent} from './timelines/timelines.component';
import {PlaylistComponent} from './playlist/playlist.component';
import {PlayerComponent} from './player/player.component';


const routes: Routes = [
  { path: 'timelines', component: TimelinesComponent },
  {path: 'youtube', component: PlaylistComponent, children:[{
    path: ':id',
      component: PlayerComponent
    }]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
