//API fetching
const url = 'https://localhost:8080/';

async function songFetchData() {
  try{
    //make fetch request to HTTP
    const response = await fetch(url);
    //handle 'response' with json
    if(!response.ok){
      throw new Error(`HTTP error: ${response.status}`);
    }
    const resp = await response.json();
    console.log(resp);
  } catch (error) {
    console.error(error);
  }
  //call function
  songFetchData();
}

//DOM assignments

const artist = document.querySelector('#artist');
const songName = document.querySelector('#title');
const songLength = document.querySelector('#timeInMinutes');
const submit = document.querySelector('#submit');


//DOM functions