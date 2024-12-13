let proximoid = 1;

const modal = document.getElementById("cadastrar");
const abrirModalButton = document.getElementById("abrirModal");
const carForm = document.getElementById("carForm");
const tabelaCarros = document.querySelector("#lista tbody");

abrirModalButton.addEventListener("click", () => {
  modal.showModal();
});

modal.addEventListener("click", (event) => {
  if (event.target === modal) {
    modal.close();
  }
});

function adicionarCarro(id, modelo, lancamento, cor, status) {
  const novaLinha = document.createElement("tr");

  novaLinha.innerHTML = `
    <td>${proximoid}</td>
    <td>${modelo}</td>
    <td>${lancamento}</td>
    <td>${cor}</td>
    <td>${status}</td>
  `;

  tabelaCarros.appendChild(novaLinha);
}

carForm.addEventListener("submit", (event) => {
  event.preventDefault(); 

  const modelo = document.getElementById("modelo").value;
  const lancamento = document.getElementById("lancamento").value;
  const cor = document.getElementById("cor").value;
  const status = document.getElementById("status").value;

  const id = Math.floor(Math.random() * 1);

  adicionarCarro(id, modelo, lancamento, cor, status);

  proximoid++;

  carForm.reset();

  modal.close();
});