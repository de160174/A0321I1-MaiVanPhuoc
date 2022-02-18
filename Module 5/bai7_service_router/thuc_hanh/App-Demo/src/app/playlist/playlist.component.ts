import { Component, OnInit } from '@angular/core';
import {YoutubeService} from "../../service/youtube.service";

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {
  constructor(public youtubeService: YoutubeService) { }

  ngOnInit(): void {
  }

}
