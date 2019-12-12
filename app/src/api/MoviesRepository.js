import axios from 'axios';

export class MoviesRepository {
  
  url = "http://localhost:8080/api/movies";

  getMovies() {
    return new Promise((resolve, reject) => {
      axios.get(`${this.url}`)
        .then(x => resolve(x.data))
        .catch(x => {
          alert(x);
          reject();
        });
    });
  }
  
}