import { MovieListPage } from './movie-list-page-model';

fixture(`Movie List`)
  .page('http://localhost:3000/');
  
const movieList = new MovieListPage();

test('should should display welcome message', async t => {
  await t.expect(movieList.title.textContent).eql('Search For Any Movie')
        .click(movieList.newMovieButton);
});