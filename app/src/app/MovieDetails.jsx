import React from 'react';
import { MoviesRepository } from '../api';
import { Link } from 'react-router-dom';

export class MovieDetails extends React.Component {

  moviesRepository = new MoviesRepository();

  state = {
    movie: {}
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
          <div id="movie" className="well">
            <div className="row">
            <div className="col-md-4">
              <img src="{this.state.movie.Poster}" className="thumbnail"/>
            </div>
            <div className="col-md-8">
              <h2>{this.state.movie.title}</h2>
              <ul className="list-group">
                <li className="list-group-item"><strong>Genre:</strong> {this.state.movie.Genre}</li>
                <li className="list-group-item"><strong>Released:</strong> {this.state.movie.Released}</li>
                <li className="list-group-item"><strong>Rated:</strong> {this.state.movie.Rated}</li>
                <li className="list-group-item"><strong>IMDB Rating:</strong> {this.state.movie.imdbRating}</li>
                <li className="list-group-item"><strong>Director:</strong> {this.state.movie.Director}</li>
                <li className="list-group-item"><strong>Writer:</strong> {this.state.movie.Writer}</li>
                <li className="list-group-item"><strong>Actors:</strong> {this.state.movie.Actors}</li>
              </ul>
            </div>
          </div>
          <div className="row">
            <div className="well">
              <h3>Plot</h3>
              {this.state.movie.Plot}
              <hr/>
              <div className="btn-group">
                  <a href="http://imdb.com/title/{this.state.movie.imdbID}" target="_blank" className="btn btn-primary">View IMDB</a>
                  <a href={'/movies/' + this.state.movie.movieId + "/edit"} className="btn btn-warning">Edit</a>
                </div>
              <a href="/" className="btn btn-default">Go Back To Search</a>
            </div>
          </div>
          </div>
        </div>
      </>
    );
  }

  componentDidMount() {
      let movieId = this.props.match.params.movieId;
      if (movieId) {
        this.moviesRepository.getMovie(movieId)
          .then(movie => this.setState({movie}));
    }
  }

}