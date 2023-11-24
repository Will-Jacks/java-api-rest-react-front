import React, { useState } from 'react';

const CadastroMedico = () => {
  const [medico, setMedico] = useState({
    nome: '',
    idade: 0
  });

  const cadastrarMedico = async () => {
    try {
      const response = await fetch('http://localhost:8080/medicos/cadastrar', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(medico)
      });

      if (response.ok) {
        console.log('Cadastro realizado com sucesso!');
      } else {
        console.error('Erro ao cadastrar médico');
      }
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setMedico((prevMedico) => ({
      ...prevMedico,
      [name]: value
    }));
  };

  return (
    <div>
      <label>
        Nome:
        <input type="text" name="nome" value={medico.nome} onChange={handleChange} />
      </label>
      <br />
      <label>
        Idade:
        <input type="number" name="idade" value={medico.idade} onChange={handleChange} />
      </label>
      <br />
      <button onClick={cadastrarMedico}>Cadastrar Médico</button>
    </div>
  );
};

export default CadastroMedico;
