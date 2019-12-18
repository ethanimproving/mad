import { Selector } from 'testcafe';

export class MovieEditorPage{
  title: Selector
  year: Selector
  rating: Selector
  runTime: Selector
  submitButton: Selector
  movies: Selector

  constructor() {
    this.title = Selector('#title');
    this.year = Selector('#year');
    this.rating = Selector('#rating');
    this.runTime = Selector('#runTime');
    this.submitButton = Selector('#root > form > div:nth-child(6) > button');
    this.movies = Selector('#movies');
  }

}