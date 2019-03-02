# pizzaria
API para pedidos em Pizzaria

A Documentação completa da API foi implementada usando Spring REST Docs e pode ser acessada em:
{context}/docs/index.html

Abaixo só alguns exemplos:

Rotas:
------------------
**GET**: /api/v1/tamanhoDaPizza
```
[
    {
        "id": 1,
        "descricao": "Pequena",
        "valor": 20,
        "tempoDePreparo": 15
    },
    {
        "id": 2,
        "descricao": "Média",
        "valor": 30,
        "tempoDePreparo": 20
    },
    {
        "id": 3,
        "descricao": "Grande",
        "valor": 40,
        "tempoDePreparo": 25
    }
]
```

**GET**: /api/v1/saborDaPizza
```
[
    {
        "id": 1,
        "descricao": "Calabresa",
        "tempoAdicional": 0
    },
    {
        "id": 2,
        "descricao": "Marguerita",
        "tempoAdicional": 0
    },
    {
        "id": 3,
        "descricao": "Portuguesa",
        "tempoAdicional": 5
    }
]
```

**GET**: /api/v1/personalizacaoDaPizza
```
[
    {
        "id": 1,
        "descricao": "Extra bacon",
        "valorAdicional": 3,
        "tempoAdicional": 0
    },
    {
        "id": 2,
        "descricao": "Sem cebola",
        "valorAdicional": 0,
        "tempoAdicional": 0
    },
    {
        "id": 3,
        "descricao": "Borda recheada",
        "valorAdicional": 5,
        "tempoAdicional": 5
    }
]
```

**GET**: /api/v1/pedido/{id}
```
{
    "id": 1,
    "pizza": {
        "id": 1,
        "tamanho": {
            "id": 1,
            "descricao": "Pequena",
            "valor": 20,
            "tempoDePreparo": 15
        },
        "sabor": {
            "id": 1,
            "descricao": "Calabresa",
            "tempoAdicional": 0
        },
        "personalizacoes": [
            {
                "id": 1,
                "descricao": "Extra bacon",
                "valorAdicional": 3,
                "tempoAdicional": 0
            }
        ]
    },
    "tempoDePreparo": 15,
    "valorFinal": 23
}
```

**POST**: /api/v1/pedido
```
{
	"pizza": {
		"tamanho": {
	        "id": 1,
	        "descricao": "Pequena",
	        "valor": 20,
	        "tempoDePreparo": 15
    	},
    	"sabor": {
	        "id": 1,
	        "descricao": "Calabresa",
	        "tempoAdicional": 0
	    },
	    "personalizacoes": [
    		 {
		        "id": 1,
		        "descricao": "Extra bacon",
		        "valorAdicional": 3,
		        "tempoAdicional": 0
		    }
	    ]
	}
}
```

**POST**: /api/v1/pedido/calcularTotais
```
{
    "id": 1,
    "pizza": {
        "id": 1,
        "tamanho": {
            "id": 1,
            "descricao": "Pequena",
            "valor": 20,
            "tempoDePreparo": 15
        },
        "sabor": {
            "id": 1,
            "descricao": "Calabresa",
            "tempoAdicional": 0
        },
        "personalizacoes": [
            {
                "id": 1,
                "descricao": "Extra bacon",
                "valorAdicional": 3,
                "tempoAdicional": 0
            }
        ]
    },
    "tempoDePreparo": 15,
    "valorFinal": 23
}
```
