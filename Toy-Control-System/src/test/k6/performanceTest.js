import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
    vus: 20, // 20 usuários simultâneos
    duration: '30s', // por 30 segundos
};

export default function () {
    // 1️⃣ GET na página principal
    let resHome = http.get('http://localhost:8080');
    check(resHome, { 'home status 200': (r) => r.status === 200 });

    // 2️⃣ POST para criar um brinquedo
    let resCreate = http.post('http://localhost:8080/api/brinquedos', JSON.stringify({
        nome: `Brinquedo ${Math.random()}`,
        tipo: 'Didático',
        classificacao: 4,
        tamanho: 'Médio',
        preco: 19.99,
    }), {
        headers: { 'Content-Type': 'application/json' },
    });
    check(resCreate, { 'create status 200 ou 201': (r) => r.status === 200 || r.status === 201 });

    // 3️⃣ GET com filtro de busca
    let resSearch = http.get('http://localhost:8080/api/brinquedos?search=Brinquedo');
    check(resSearch, { 'search status 200': (r) => r.status === 200 });

    sleep(1); // simula pausa entre ações
}
