import { Selector } from 'testcafe';

export class MovieListPage{
  title: Selector
  searchTitle: Selector
  newMovieButton: Selector

  constructor() {
    this.title = Selector('#root > div.container > div.jumbotron > h3');
    this.searchTitle = Selector('#root > div:nth-child(2) > div > h3');
    this.newMovieButton = Selector('#root > div.findSection > div > a:nth-child(2)');
  }

}