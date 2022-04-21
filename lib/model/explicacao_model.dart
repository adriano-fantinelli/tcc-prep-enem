import 'package:prepenem/model/questao_model.dart';
import 'package:prepenem/model/usuario_model.dart';

class ExplicacaoModel {
  int? id;
  String? textoExplicacao;
  UsuarioModel? usuarioModel;
  QuestaoModel? questaoModel;

  ExplicacaoModel(
      {this.id, this.textoExplicacao, this.usuarioModel, this.questaoModel});
}
