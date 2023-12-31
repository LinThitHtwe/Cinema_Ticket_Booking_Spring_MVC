const container = document.querySelector('.container');
const seatsAs = document.querySelectorAll('.row .seatA:not(.occupied');
const seatsBs = document.querySelectorAll('.row.seatB:not(.occupied');
const seatsC = document.querySelectorAll('.row .seatC:not(.occupied');
const seatsD = document.querySelectorAll('.row .seatD:not(.occupied');
const seatsE = document.querySelectorAll('.row .seatE:not(.occupied');
const coupleseats = document.querySelectorAll('.row .coupleseat:not(.occupied');
const count = document.getElementById('count');
const total = document.getElementById('total');
const movieSelect = document.getElementById('movie');

populateUI();
let ticketPrice = +movieSelect.value;

// Save selected movie index and price
function setChairData(movieIndex, moviePrice) {
  localStorage.setItem('selectedChairIndex', movieIndex);
  localStorage.setItem('selectedChairAPrice', moviePrice);
   localStorage.setItem('selectedChairBPrice', moviePrice);
    localStorage.setItem('selectedChairCPrice', moviePrice);
     localStorage.setItem('selectedChairDPrice', moviePrice);
      localStorage.setItem('selectedChairEPrice', moviePrice);
       localStorage.setItem('selectedChairPrice', moviePrice);
}


function updateSelectedCount() {
//   const selectedSeats = document.querySelectorAll('.row .seat.selected');
//   const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));
//   localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));
//   const selectedSeatsCount = selectedSeats.length;
//   count.innerText = selectedSeatsCount;
//   total.innerText = selectedSeatsCount * ticketPrice;
// //----------------------Row A------------------------------------------
//   const selectedSeats = document.querySelectorAll('.row .seat.selected');
//   const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));
//   localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));
//   const selectedSeatsCount = selectedSeats.length;
//   count.innerText = selectedSeatsCount;
//   total.innerText = selectedSeatsCount * ticketPrice;

// //------------------------Row B--------------------------------------------

// //--------------------------------------------------------------------------

//   // const selectedSeatsB = document.querySelectorAll('.row.seatB.selected');
//   // const seatsBIndex = [...selectedSeatsB].map((seatB) => [...seatBs].indexOf(seatB));
//   // localStorage.setItem('selectedSeatsB', JSON.stringify(seatsBIndex));
//   // const selectedSeatsBCount = selectedSeatsB.length;
//   // count.innerText = selectedSeatsBCount;
//   // total.innerText = selectedSeatsBCount * ticketPrice;
// //--------------------------------------------------------------------
//   const selectedSeatsB = document.querySelectorAll('.row .seatB.selected');
//   const seatsBIndex = [...selectedCoupleSeats].map((seatB) => [...seatsBs].indexOf(seatB));
//   localStorage.setItem('selectedSeatsB', JSON.stringify(seatsBIndex));
//   const selectedSeatsBCount = selectedSeatsB.length;
//   count.innerText = selectedSeatsBCount;
//   total.innerText = selectedSeatsBCount * ticketPrice;
//-----------------------------------------------------------
  const selectedCoupleSeats = document.querySelectorAll('.row .coupleseat.selected');
  const seatsCoupleIndex = [...selectedCoupleSeats].map((coupleseat) => [...coupleseats].indexOf(coupleseat));
  localStorage.setItem('selectedCoupleSeats', JSON.stringify(seatsCoupleIndex));
  const selectedCoupleSeatsCount = selectedCoupleSeats.length;
  count.innerText = selectedCoupleSeatsCount;
  total.innerText = selectedCoupleSeatsCount * ticketPrice;
}

// get data from localstorage and populate ui
function populateUI() {
  const selectedSeats = JSON.parse(localStorage.getItem('selectedSeats'));
  if (selectedSeats !== null && selectedSeats.length > 0) {
    seats.forEach((seat, index) => {
      if (selectedSeats.indexOf(index) > -1) {
        seat.classList.add('selected');
      }
    });
  }
  //-----------------Row A-------------------------
  const selectedSeatsA = JSON.parse(localStorage.getItem('selectedSeatsA'));
  if (selectedSeatsA !== null && selectedSeatsA.length > 0) {
    seatsA.forEach((seatA, index) => {
      if (selectedSeatsA.indexOf(index) > -1) {
        seatA.classList.add('selected');
      }
    });
  }
  //------------------Row B---------------------------

  const selectedSeatsB = JSON.parse(localStorage.getItem('selectedSeatsB'));
  if (selectedSeatsB !== null && selectedSeatsB.length > 0) {
    seatsB.forEach((seatB, index) => {
      if (selectedSeatsB.indexOf(index) > -1) {
        seatB.classList.add('selected');
      }
    });
  }
  //--------------------Row C-----------------------------
  const selectedSeatsC = JSON.parse(localStorage.getItem('selectedSeatsC'));
  if (selectedSeatsC !== null && selectedSeatsC.length > 0) {
    seatsC.forEach((seatC, index) => {
      if (selectedSeatsC.indexOf(index) > -1) {
        seatC.classList.add('selected');
      }
    });
  }
//------------------------Row D---------------------------------------------
  const selectedSeatsD = JSON.parse(localStorage.getItem('selectedSeatsD'));
  if (selectedSeatsD !== null && selectedSeatsD.length > 0) {
    seatsD.forEach((seatD, index) => {
      if (selectedSeatsD.indexOf(index) > -1) {
        seatD.classList.add('selected');
      }
    });
  }
  //------------------------Row E--------------------------------
  const selectedSeatsE = JSON.parse(localStorage.getItem('selectedSeatsE'));
  if (selectedSeatsE !== null && selectedSeatsE.length > 0) {
    seatsE.forEach((seatE, index) => {
      if (selectedSeatsE.indexOf(index) > -1) {
        seatE.classList.add('selected');
      }
    });
  }


  //----------------------------------------

  const selectedCoupleSeats = JSON.parse(localStorage.getItem('selectedCoupleSeats'));
  if (selectedCoupleSeats !== null && selectedCoupleSeats.length > 0) {
    coupleseats.forEach((coupleseat, index) => {
      if (selectedCoupleSeats.indexOf(index) > -1) {
        coupleseat.classList.add('selected');
      }
    });
  }

  const selectedMovieIndex = localStorage.getItem('selectedMovieIndex');

  if (selectedMovieIndex !== null) {
    movieSelect.selectedIndex = selectedMovieIndex;
  }
}

// Movie select event
movieSelect.addEventListener('change', (e) => {
  ticketPrice = +e.target.value;
  setMovieData(e.target.selectedIndex, e.target.value);
  updateSelectedCount();
});

// Seat click event
container.addEventListener('click', (e) => {
  if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }
  //-------------Row A-----------------------------------

    if (e.target.classList.contains('seatA') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }

  //--------------------Row B------------------------------------

    if (e.target.classList.contains('seatB') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }

  //--------------------Row C----------------------
    if (e.target.classList.contains('seatC') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }
  //--------------------------Row D--------------------------------
    if (e.target.classList.contains('seatD') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }
//------------------------------Row E----------------------------------------------
    if (e.target.classList.contains('seatE') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }


  //---------------------------------------------------

  if (e.target.classList.contains('coupleseat') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }
});

// intial count and total
updateSelectedCount();