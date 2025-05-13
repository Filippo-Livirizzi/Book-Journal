async function fecthBookInfo(titolo, autore = '') {
    const query = encodeURIComponent(`${titolo} ${autore}`);
    const url = `https://www.googleapis.com/books/v1/volumes?q=${query}`; //q= è il parametro di ricerca

    const response = await fetch(url); // assegnio alla variabile response il risultato della fetch
    const data = await response.json(); // converto la risposta in formato json

    if(data.totalItems > 0){
        const book = data.items[0].volumeInfo; // prendo il primo libro della lista Array
        document.getElementById('descrizione').innerHTML = book.description || ''; // se non c'è la descrizione metto un messaggio
        document.getElementById('isbn').innerHTML = book.identifier || '**';
        document.getElementById('genere').innerHTML = book.categories || '';
        document.getElementById('immagine').innerHTML = book.imageLinks?.thumbnail || '';
      //  document.getElementById('coverPreview').innerHTML.src = book.imageLinks?.thumbnail || '';
    }
}

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById('titolo').addEventListener('blur', () => {
        const title = document.getElementById('titolo').value;
        const author = document.getElementById('autore').value;
        if (title.length > 2){
            fecthBookInfo(title, author);   
        }
    });
    });