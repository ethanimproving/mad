import React from 'react';
import { MoviesRepository } from '../api';


export class DeletedMovies extends React.Component {

  moviesRepository = new MoviesRepository();

  state = {
    movies: []
  }

  render() {
    return (
      <>
        <div className="findSection">
          <h3 className="findSectionHeader"><a name="tt"></a>Deleted Titles</h3>
          <table className="findList">
              <tbody>
              {this.state.movies.map((movie, i) => (
                <tr key={i} className={"findResult " + (i % 2 == 0 ? 'even' : 'odd')}>
                  <td className="primary_photo"> <a href={"/movie/" + movie.movieId}></a> </td>
                  <td className="result_text"> <a href={"/movie/" + movie.movieId}>{movie.title}</a> ({movie.year}) </td>
                  <td>
                    <button type="button"
                        className="btn btn-sm btn-primary"
                        onClick={e => this.onDelete(movie.movieId) }>
                        Restore
                    </button>
                  </td>
                </tr>
              ))}
              </tbody>
          </table>
        </div>
      </>
    );
  }

  componentDidMount() {
    this.moviesRepository.getDeletedMovies()
      .then(movies => this.setState({movies}));
  }

  onDelete(movieId) {
    if(window.confirm('Are you sure you want to delete?')) {
      this.moviesRepository.restoreMovie(movieId)
        .then(() => {
          this.setState(prevState => ({
              message: 'Movie has been deleted',
              movies: prevState.movies.filter(x => x.movieId !== movieId)
          }));
      });
    }
  }

}