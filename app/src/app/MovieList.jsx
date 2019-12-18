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
      <nav className="navbar navbar-default">
          <div className="container">
            <div className="navbar-header">
              <a className="navbar-brand" href="/">MovieInfo</a>
            </div>
          </div>
        </nav>

        <div className="container">
          <div className="jumbotron">
            <h3 className="text-center">Search For Any Movie</h3>
            <form id="searchForm">
              <input type="text" className="form-control" id="searchText" placeholder="Search Movies..."/>
            </form>
          </div>

          <div id="movies" className="row">
            {this.state.movies.map((movie, i) => (
            <div key={i} className="col-md-3">
              <div className="well text-center">
                <img src="https://via.placeholder.com/510x762.png"/>
                <h5>{movie.title}</h5>
                <a className="btn btn-primary" href={"/movie/" + movie.movieId}>Movie Details</a>
              </div>
            </div>
            ))}
          </div>
          
        </div>

        

        

        <div className="container">
          <div id="movies" className="row"></div>
        </div>


        <div className="findSection">
          <h3 className="findSectionHeader"><a name="tt"></a>Titles</h3>
          <table className="findList">
              <tbody>
              {this.state.movies.map((movie, i) => (
                <tr key={i} className={"findResult " + (i % 2 == 0 ? 'even' : 'odd')}>
                  <td className="primary_photo"> <a href={"/movie/" + movie.movieId}></a> </td>
                  <td className="result_text"> <a href={"/movie/" + movie.movieId}>{movie.title}</a> ({movie.year}) </td>
                  <td>
                    <button type="button"
                        className="btn btn-sm btn-danger"
                        onClick={e => this.onDelete(movie.movieId) }>
                        X
                    </button>
                  </td>
                </tr>
              ))}
              </tbody>
          </table>
          <div className="findMoreMatches">
              View:&nbsp; <a href="#give-me-more-please-and-thank-you:)!">More title matches</a>
              &nbsp;or&nbsp;
              <a href="/new">Create a new title</a>
          </div>
        </div>
      </>
    );
  }

  componentDidMount() {
    this.moviesRepository.getMovies()
      .then(movies => this.setState({movies}));
  }

  onDelete(movieId) {
    if(window.confirm('Are you sure you want to delete?')) {
      this.moviesRepository.deleteMovie(movieId)
        .then(() => {
          this.setState(prevState => ({
              message: 'Movie has been deleted',
              movies: prevState.movies.filter(x => x.movieId !== movieId)
          }));
      });
    }
  }

}