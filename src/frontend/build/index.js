// API URL
const url = 'http://localhost:8080/api/song';

// Fetch songs from the server
async function fetchSongs() {
  console.log("fetchSongs called")
  const url = 'http://localhost:8080/api/song';
  const response = await fetch(url, {method: "GET"});
  console.log(response);
  const songs = await response.json();
  const tableBody = document.querySelector('#songTable tbody');
  tableBody.innerHTML = '';

  // Loop through the songs and add them to the table
  songs.forEach(song => {
    const row = document.createElement('tr');

    const idCell = document.createElement('td');
    idCell.textContent = song.id;
    row.appendChild(idCell);

    const artistCell = document.createElement('td');
    artistCell.textContent = song.artist;
    row.appendChild(artistCell);

    const titleCell = document.createElement('td');
    titleCell.textContent = song.songName;
    row.appendChild(titleCell);

    const durationCell = document.createElement('td');
    durationCell.textContent = song.songLength;
    row.appendChild(durationCell);

    tableBody.appendChild(row);
  });
}

// Call fetchSongs function
fetchSongs();

// DOM assignments
const submit = document.querySelector('#submit');

// Post a new song
async function postSong(event) {
  event.preventDefault();
  const artist = document.querySelector('#artistInput');
  const title = document.querySelector('#titleInput');
  const duration = document.querySelector('#timeInput');

  const songDto = {
    artist: artist.value,
    songName: title.value,
    songLength: duration.value
  };

  const requestObj = {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(songDto)
  };

  await fetch(url, requestObj);
  await fetchSongs();

  // Reset the form inputs
  artist.value = '';
  title.value = '';
  duration.value = '';
}

// Add event listener to the form submit button
const form = document.querySelector("#songForm");
form.addEventListener('submit', postSong);