const myheaders = new Headers();

const init = {
    method: 'GET',
    headers: myheaders,
    mode: 'cors',
    cache: 'default'
};

fetch('/rest/commande/valide', init).then(function (commandes) {
    if (commandes.ok) {
        return "ok";
    }
    commandes.json();
    console.log(commandes);
}).then(function (commande) {
    console.log(commande);
    document.getElementById('commande').append(commande);
});