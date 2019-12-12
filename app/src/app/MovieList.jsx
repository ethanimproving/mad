import React from 'react';
import { MoviesRepository } from '../api';


export class MovieList extends React.Component {

  moviesRepository = new MoviesRepository();

  state = {
    movies: []
  }

  render() {
    return (
      <>
        <div class="findSection">
          <h3 class="findSectionHeader"><a name="tt"></a>Titles</h3>
          <table class="findList">
              <tbody>
              {this.state.movies.map((movie, i) => (
                <tr key={i} class={"findResult " + (i % 2 == 0 ? 'even' : 'odd')}>
                  <td class="primary_photo"> <a href={"/" + movie.movieId}></a> </td>
                  <td class="result_text"> <a href={"/" + movie.movieId}>{movie.title}</a> ({movie.year}) </td>
                </tr>
              ))}
              </tbody>
          </table>
          <div class="findMoreMatches">
              View:&nbsp; <a href="#give-me-more-damn-it!">More title matches</a>
              &nbsp;or&nbsp;
              <a href="#we-don't-use-those-kinds-of-words">Exact title matches</a>
          </div>
        </div>
      </>
    );
  }

  componentDidMount() {
    this.moviesRepository.getMovies()
      .then(movies => this.setState({movies}));
  }

}