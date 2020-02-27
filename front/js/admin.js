const myheaders = new Headers();

const init = {method: 'GET',
            headers: myheaders,
            mode: 'cors',
            cache: 'default'};

fetch('/commande/commande-jour', init).then(function (commandes) {
        commandes.json();
}).then(function (commande) {
    document.getElementById('commande').append(commande);
});