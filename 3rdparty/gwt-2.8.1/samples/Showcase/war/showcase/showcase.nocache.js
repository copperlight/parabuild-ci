function showcase(){var U='bootstrap',V='begin',W='gwt.codesvr.showcase=',X='gwt.codesvr=',Y='showcase',Z='startup',$='DUMMY',_=0,ab=1,bb='iframe',cb='javascript:""',db='position:absolute; width:0; height:0; border:none; left: -1000px;',eb=' top: -1000px;',fb='CSS1Compat',gb='<!doctype html>',hb='',ib='<html><head><\/head><body><\/body><\/html>',jb='undefined',kb='readystatechange',lb=10,mb='Chrome',nb='eval("',ob='");',pb='script',qb='javascript',rb='moduleStartup',sb='moduleRequested',tb='Failed to load ',ub='head',vb='meta',wb='name',xb='showcase::',yb='::',zb='gwt:property',Ab='content',Bb='=',Cb='gwt:onPropertyErrorFn',Db='Bad handler "',Eb='" for "gwt:onPropertyErrorFn"',Fb='gwt:onLoadErrorFn',Gb='" for "gwt:onLoadErrorFn"',Hb='#',Ib='?',Jb='/',Kb='img',Lb='clear.cache.gif',Mb='baseUrl',Nb='showcase.nocache.js',Ob='base',Pb='//',Qb='locale',Rb='en',Sb='locale=',Tb=7,Ub='&',Vb='SHOWCASE_LOCALE=',Wb=';',Xb=16,Yb='_',Zb='__gwt_Locale',$b='Unexpected exception in locale detection, using default: ',_b=2,ac=3,bc=4,cc='user.agent',dc='webkit',ec='safari',fc='msie',gc=11,hc='ie10',ic=9,jc='ie9',kc=8,lc='ie8',mc='gecko',nc='gecko1_8',oc='selectingPermutation',pc='showcase.devmode.js',qc='0F28E62F1A9137FF2F5771829E851333',rc='ar',sc='1AE35282B34180D77CACCDA224BC30A9',tc='default',uc='2A3F3181B9DB4EBC9D450A8241C3CCFB',vc='2DAF8ABB2B5477C3D938B0A23CD69C6C',wc='2F2917AE0EF034B1DDD82FCB3D6D6159',xc='360AF032554176B59F447AF446A5DA7B',yc='zh',zc='5484F21BE60CF7F9353FD69098827578',Ac='5D7E6930A54EB9155B5AE42383D2C96D',Bc='6650375722E7390271BA2055EA19C0F2',Cc='71F54D0190D3480CAF67289AFD860563',Dc='7AEDF088AA3A69FE88EBC45EBB5801B9',Ec='830B772B78EAA1887507DA2F27111903',Fc='fr',Gc='840F9CD2A4B286073F76EC6B1E5ABCA1',Hc='85B2111B5EA60A92CBED2458791D3ABE',Ic='88C1DA300CA9149A449ABF5926B734BB',Jc='8B44449CF737281BF8A76F4FF3546086',Kc='8EF8D1B5ED52CA9FDFE7DCFF196090E0',Lc='ADF06FB5B9664417A56B46C5AA5AE445',Mc='BACF184D1BFFBEC333DFE679173BE93B',Nc='BF54AF16FE0A6E17CF078A2526B1C4E8',Oc='C1ABC490EC85E6BDF8A9CCE495BBE567',Pc='C6827B51475CAA3BD8C8C7A123E6CCCF',Qc='CCF2AF125518816D833DA191F131DD8F',Rc='D79438991F2C5CC262F6E76F968869A7',Sc='FFBF40838B0647EC595EF531000B4CCC',Tc=':',Uc='.cache.js',Vc='loadExternalRefs',Wc='end',Xc='http:',Yc='file:',Zc='_gwt_dummy_',$c='__gwtDevModeHook:showcase',_c='Ignoring non-whitelisted Dev Mode URL: ',ad=':moduleBase';var u=window;var v=document;A(U,V);function w(){var a=u.location.search;return a.indexOf(W)!=-1||a.indexOf(X)!=-1}
function A(a,b){if(u.__gwtStatsEvent){u.__gwtStatsEvent({moduleName:Y,sessionId:u.__gwtStatsSessionId,subSystem:Z,evtGroup:a,millis:(new Date).getTime(),type:b})}}
showcase.__sendStats=A;showcase.__moduleName=Y;showcase.__errFn=null;showcase.__moduleBase=$;showcase.__softPermutationId=_;showcase.__computePropValue=null;showcase.__getPropMap=null;showcase.__installRunAsyncCode=function(){};showcase.__gwtStartLoadingFragment=function(){return null};showcase.__gwt_isKnownPropertyValue=function(){return false};showcase.__gwt_getMetaProperty=function(){return null};var B=null;var C=u.__gwt_activeModules=u.__gwt_activeModules||{};C[Y]={moduleName:Y};showcase.__moduleStartupDone=function(e){var f=C[Y].bindings;C[Y].bindings=function(){var a=f?f():{};var b=e[showcase.__softPermutationId];for(var c=_;c<b.length;c++){var d=b[c];a[d[_]]=d[ab]}return a}};var D;function F(){G();return D}
function G(){if(D){return}var a=v.createElement(bb);a.src=cb;a.id=Y;a.style.cssText=db+eb;a.tabIndex=-1;v.body.appendChild(a);D=a.contentDocument;if(!D){D=a.contentWindow.document}D.open();var b=document.compatMode==fb?gb:hb;D.write(b+ib);D.close()}
function H(k){function l(a){function b(){if(typeof v.readyState==jb){return typeof v.body!=jb&&v.body!=null}return /loaded|complete/.test(v.readyState)}
var c=b();if(c){a();return}function d(){if(!c){if(!b()){return}c=true;a();if(v.removeEventListener){v.removeEventListener(kb,d,false)}if(e){clearInterval(e)}}}
if(v.addEventListener){v.addEventListener(kb,d,false)}var e=setInterval(function(){d()},lb)}
function m(c){function d(a,b){a.removeChild(b)}
var e=F();var f=e.body;var g;if(navigator.userAgent.indexOf(mb)>-1&&window.JSON){var h=e.createDocumentFragment();h.appendChild(e.createTextNode(nb));for(var i=_;i<c.length;i++){var j=window.JSON.stringify(c[i]);h.appendChild(e.createTextNode(j.substring(ab,j.length-ab)))}h.appendChild(e.createTextNode(ob));g=e.createElement(pb);g.language=qb;g.appendChild(h);f.appendChild(g);d(f,g)}else{for(var i=_;i<c.length;i++){g=e.createElement(pb);g.language=qb;g.text=c[i];f.appendChild(g);d(f,g)}}}
showcase.onScriptDownloaded=function(a){l(function(){m(a)})};A(rb,sb);var n=v.createElement(pb);n.src=k;if(showcase.__errFn){n.onerror=function(){showcase.__errFn(Y,new Error(tb+code))}}v.getElementsByTagName(ub)[_].appendChild(n)}
showcase.__startLoadingFragment=function(a){return K(a)};showcase.__installRunAsyncCode=function(a){var b=F();var c=b.body;var d=b.createElement(pb);d.language=qb;d.text=a;c.appendChild(d);c.removeChild(d)};function I(){var c={};var d;var e;var f=v.getElementsByTagName(vb);for(var g=_,h=f.length;g<h;++g){var i=f[g],j=i.getAttribute(wb),k;if(j){j=j.replace(xb,hb);if(j.indexOf(yb)>=_){continue}if(j==zb){k=i.getAttribute(Ab);if(k){var l,m=k.indexOf(Bb);if(m>=_){j=k.substring(_,m);l=k.substring(m+ab)}else{j=k;l=hb}c[j]=l}}else if(j==Cb){k=i.getAttribute(Ab);if(k){try{d=eval(k)}catch(a){alert(Db+k+Eb)}}}else if(j==Fb){k=i.getAttribute(Ab);if(k){try{e=eval(k)}catch(a){alert(Db+k+Gb)}}}}}__gwt_getMetaProperty=function(a){var b=c[a];return b==null?null:b};B=d;showcase.__errFn=e}
function J(){function e(a){var b=a.lastIndexOf(Hb);if(b==-1){b=a.length}var c=a.indexOf(Ib);if(c==-1){c=a.length}var d=a.lastIndexOf(Jb,Math.min(c,b));return d>=_?a.substring(_,d+ab):hb}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=v.createElement(Kb);b.src=a+Lb;a=e(b.src)}return a}
function g(){var a=__gwt_getMetaProperty(Mb);if(a!=null){return a}return hb}
function h(){var a=v.getElementsByTagName(pb);for(var b=_;b<a.length;++b){if(a[b].src.indexOf(Nb)!=-1){return e(a[b].src)}}return hb}
function i(){var a=v.getElementsByTagName(Ob);if(a.length>_){return a[a.length-ab].href}return hb}
function j(){var a=v.location;return a.href==a.protocol+Pb+a.host+a.pathname+a.search+a.hash}
var k=g();if(k==hb){k=h()}if(k==hb){k=i()}if(k==hb&&j()){k=e(v.location.href)}k=f(k);return k}
function K(a){if(a.match(/^\//)){return a}if(a.match(/^[a-zA-Z]+:\/\//)){return a}return showcase.__moduleBase+a}
function L(){var m=[];var n=_;function o(a,b){var c=m;for(var d=_,e=a.length-ab;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
var p=[];var q=[];function r(a){var b=q[a](),c=p[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(B){B(a,d,b)}throw null}
q[Qb]=function(){var b=null;var c=Rb;try{if(!b){var d=location.search;var e=d.indexOf(Sb);if(e>=_){var f=d.substring(e+Tb);var g=d.indexOf(Ub,e);if(g<_){g=d.length}b=d.substring(e+Tb,g)}}if(!b){var h=v.cookie;var i=h.indexOf(Vb);if(i>=_){var g=h.indexOf(Wb,i);if(g<_){g=h.length}b=h.substring(i+Xb,g)}}if(!b){b=__gwt_getMetaProperty(Qb)}if(!b){var j=navigator.browserLanguage?navigator.browserLanguage:navigator.language;if(j){var k=j.split(/[-_]/);if(k.length>ab){k[ab]=k[ab].toUpperCase()}b=k.join(Yb)}}if(!b){b=u[Zb]}if(b){c=b}while(b&&!__gwt_isKnownPropertyValue(Qb,b)){var l=b.lastIndexOf(Yb);if(l<_){b=null;break}b=b.substring(_,l)}}catch(a){alert($b+a)}u[Zb]=c;return b||Rb};p[Qb]={'ar':_,'default':ab,'en':_b,'fr':ac,'zh':bc};q[cc]=function(){var a=navigator.userAgent.toLowerCase();var b=v.documentMode;if(function(){return a.indexOf(dc)!=-1}())return ec;if(function(){return a.indexOf(fc)!=-1&&(b>=lb&&b<gc)}())return hc;if(function(){return a.indexOf(fc)!=-1&&(b>=ic&&b<gc)}())return jc;if(function(){return a.indexOf(fc)!=-1&&(b>=kc&&b<gc)}())return lc;if(function(){return a.indexOf(mc)!=-1||b>=gc}())return nc;return hb};p[cc]={'gecko1_8':_,'ie10':ab,'ie8':_b,'ie9':ac,'safari':bc};__gwt_isKnownPropertyValue=function(a,b){return b in p[a]};showcase.__getPropMap=function(){var a={};for(var b in p){if(p.hasOwnProperty(b)){a[b]=r(b)}}return a};showcase.__computePropValue=r;u.__gwt_activeModules[Y].bindings=showcase.__getPropMap;A(U,oc);if(w()){return K(pc)}var s;try{o([Rb,lc],qc);o([rc,nc],sc);o([tc,hc],uc);o([rc,hc],vc);o([Rb,nc],wc);o([tc,jc],xc);o([yc,lc],zc);o([Rb,hc],Ac);o([rc,lc],Bc);o([Rb,ec],Cc);o([yc,jc],Dc);o([tc,nc],Ec);o([Fc,hc],Gc);o([Fc,nc],Hc);o([tc,lc],Ic);o([Rb,jc],Jc);o([tc,ec],Kc);o([Fc,lc],Lc);o([yc,nc],Mc);o([Fc,jc],Nc);o([yc,hc],Oc);o([rc,ec],Pc);o([rc,jc],Qc);o([yc,ec],Rc);o([Fc,ec],Sc);s=m[r(Qb)][r(cc)];var t=s.indexOf(Tc);if(t!=-1){n=parseInt(s.substring(t+ab),lb);s=s.substring(_,t)}}catch(a){}showcase.__softPermutationId=n;return K(s+Uc)}
function M(){if(!u.__gwt_stylesLoaded){u.__gwt_stylesLoaded={}}A(Vc,V);A(Vc,Wc)}
I();showcase.__moduleBase=J();C[Y].moduleBase=showcase.__moduleBase;var N=L();if(u){var O=!!(u.location.protocol==Xc||u.location.protocol==Yc);u.__gwt_activeModules[Y].canRedirect=O;function P(){var b=Zc;try{u.sessionStorage.setItem(b,b);u.sessionStorage.removeItem(b);return true}catch(a){return false}}
if(O&&P()){var Q=$c;var R=u.sessionStorage[Q];if(!/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/.test(R)){if(R&&(window.console&&console.log)){console.log(_c+R)}R=hb}if(R&&!u[Q]){u[Q]=true;u[Q+ad]=J();var S=v.createElement(pb);S.src=R;var T=v.getElementsByTagName(ub)[_];T.insertBefore(S,T.firstElementChild||T.children[_]);return false}}}M();A(U,Wc);H(N);return true}
showcase.succeeded=showcase();