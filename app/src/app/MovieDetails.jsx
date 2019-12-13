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
        <div>
          <nav>
            <ol className="breadcrumb">
              <li className="breadcrumb-item">
                <a href="/">Home</a>
              </li>
              <li className="breadcrumb-item active">{this.state.movie.title}</li>
            </ol>
          </nav>
          <div className="container p-5 bg-light">
            <div className="d-flex">
              <div>
                <h1 className="font-weight-light">{this.state.movie.title}</h1>
                <p className="text-muted mt-4">{this.state.movie.year}</p>
                <span className="badge badge-primary badge-lg">
                  Rating: {this.state.movie.rating}
                </span>
                <Link to={'/movies/' + this.state.movie.movieId + "/edit"}>Edit</Link>
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