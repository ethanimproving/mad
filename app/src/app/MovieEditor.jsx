import React from 'react';
import { MoviesRepository } from '../api';
import { Link, Redirect } from 'react-router-dom';

export class MovieEditor extends React.Component{

    moviesRepository = new MoviesRepository();  

    state = {
      title: '',
      year: '', 
      rating: '',
      runTime: '',
    };
   

    render(){
        return <>
            {this.state.redirect && <Redirect to="/" /> }
            <form className="container">
                <h1>Movie Editor</h1>
                <div className="form-group">
                    <label htmlFor="title">
                        Name
                    </label>
                    <input type="text"
                            id="title"
                            name="title"
                            className="form-control"
                            value={this.state.title}
                            onChange= {e => this.setState({title: e.target.value} ) } 
                            />
                </div>

                <div className="form-group">
                    <label htmlFor="year">
                        Year
                    </label>
                    <input type="text"
                            id="year"
                            name="year"
                            className="form-control"
                            value={this.state.year}
                            onChange= {e => this.setState({year: e.target.value} ) } />

                </div>
                
                <div className="form-group">
                    <label htmlFor="rating">
                        Rating
                    </label>
                    <input type="text"
                            id="rating"
                            name="rating"
                            className="form-control"
                            value={this.state.rating}
                            onChange= {e => this.setState({rating: e.target.value} ) } />

                </div>

                <div className="form-group">
                    <label htmlFor="runTime">
                        Runtime
                    </label>
                    <input type="text"
                            id="runTime"
                            name="runTime"
                            className="form-control"
                            value={this.state.runTime}
                            onChange= {e => this.setState({runTime: e.target.value} ) } />

                </div>              
                
               <div>
                    <button type="button"  className="btn btn-primary btn-lg btn-block" 
                    onClick={ e => this.onSubmit() }>
                        Save
                    </button>
                    <Link to="/"
                        className="btn btn-secondary btn-block"
                         >
                            Return to List
                    </Link>
                </div>

            </form>
        </>;
    }
    componentDidMount(){
        let movieId = this.props.match.params.movieId;
        if(movieId){
            this.moviesRepository.getMoviesById(movieId)
        .then(movie => this.setState(movie));
        }
        
    }
    
    onSubmit(){
        var onSaveComplete = () => this.setState({redirect: true});
        if(this.state.id){
            this.moviesRepository.updateMovie(this.state.id, this.state)
            .then(onSaveComplete);
        }else{
            this.moviesRepository.addMovie(this.state).then(onSaveComplete);
        }
    }
}