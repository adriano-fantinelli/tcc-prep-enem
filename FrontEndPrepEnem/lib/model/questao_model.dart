import 'package:prepenem/model/alternativa_model.dart';
import 'package:prepenem/model/desempenho_model.dart';
import 'package:prepenem/model/explicacao_model.dart';

class QuestaoModel {
  int? id;
  String? enunciado;
  String? matrizCurricular;
  String? anoProva;
  String? imagem;
  ExplicacaoModel? explicacaoModel;
  Set<AlternativaModel>? alternativaModel;
  Set<DesempenhoModel>? desempenhoModel;

  QuestaoModel(
      {this.id,
      this.enunciado,
      this.matrizCurricular,
      this.anoProva,
      this.imagem,
      this.explicacaoModel,
      this.alternativaModel,
      this.desempenhoModel});
}
