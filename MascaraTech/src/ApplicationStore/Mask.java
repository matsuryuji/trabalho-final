/* Trabalho Prático - Sistema de Administração de Vendas de Máscaras
*  Programadores: Matheus Ryuji Matsutane
*  Criação: 09/12/2020 | Última atualização: 15/12/2020
*  */


package ApplicationStore;

// Declaração da classe Mask (Máscaras)
// Define id (identificação), descrição (description),
// estoque (stock), vendas diárias (dailySale),
// preço de produção (productionPrice) e preço de vendas
// (salePrice).

class Mask {
	
    private int id;
    private String description;
    
    private int stock;
    private int dailySale;
    
    private float productionPrice;
    private float salePrice;
    
    // MÉTODO Mask - Máscara (mask)
    // Recebe e armazena o ID, descrição, preço de produção e
    // preço de vendas de cada objeto do tipo máscara
    
    public Mask(int id, String description, float productionPrice, float salePrice){
        this.id = id;
        this.stock = 0;
        this.dailySale = 0;
        setProductionPrice(productionPrice);
        setSalePrice(salePrice);
        this.description = description;
    }
    
    // MÉTODO registerDailySale
    // Verifica se a quantidade é maior que 0, registra as
    // vendas (aumenta as vendas e diminui estoque), informa
    // o sucesso da operação.
    // Se venda > estoque, imprime mensagem de erro.
    
    public String registerDailySale(int quantity){
        if(quantity < 1){
            return "Quantidade deve ser maior que 0.";
        }
        
        if(stock - quantity >= 0){
            dailySale += quantity;
            stock -= quantity;
            return "Venda registrada com sucesso.";
        } else {
            return "Não é possível vender uma quantidade maior que a em estoque.";
        } 
    }
    
    // MÉTODO getDailySale
    // Retorna a quantidade vendida no dia
    
    public int getDailySale(){
        return dailySale;
    }
    
    // MÉTODO setDailyStock
    // Atualiza o estoque baseado na quantidade
    // fornecida como parâmetro, originada pelo usuário.
    
    public String setDailyStock(int quantity){
        if(quantity > 0){
            stock = quantity;
            return "Estoque atualizado com sucesso.";
        } else {
            return "Quantidade deve ser maior que 0.";
        }
    }
    
    // MÉTODO getDailyStock
    // Retorna a quantidade de estoque no dia
    
    public int getDailyStock(){
        return stock;
    }
    
    // MÉTODO setProductionPrice
    // Verifica se o custo de produção é maior que zero,
    // e então atualiza-o (após receber do usuário).
    
    public String setProductionPrice(float price){
        if(price >= 0){
            this.productionPrice = price;
            return "Preço de produção atualizado com sucesso.";
        } else {
            return "Preço de produção deve ser maior que 0.";
        }
    }
    
    // MÉTODO getProductionPrice
    // Retorna o custo de produção
    
    public float getProductionPrice(){
        return productionPrice;
    }
    
    // MÉTODO setSalePrice
    // Verifica se o preço de venda é maior que zero,
    // e então atualiza-o (após receber do usuário).
    
    public String setSalePrice(float price){
        if(price >= 0){
            this.salePrice = price;
            return "Preço de venda atualizado com sucesso.";
        } else {
            return "Preço de venda deve ser maior que 0.";
        }
    }
    
    // MÉTODO getSalePrice
    // Retorna o preço de vendas
    
    public float getSalePrice() {
        return salePrice;
    }
    
    // MÉTODO getDescription
    // Retorna a descrição do produto
    
    public String getDescription(){
        return description;
    }
}

/* Trabalho Prático - Sistema de Administração de Vendas de Máscaras
*  Programadores: Matheus Ryuji Matsutane
*  Criação: 09/12/2020 | Última atualização: 15/12/2020
*  */