local k = import 'ksonnet/ksonnet.beta.3/k.libsonnet';

local pvc = k.core.v1.persistentVolumeClaim;

local kp =
  (import 'kube-prometheus/kube-prometheus.libsonnet') +
  // Uncomment the following imports to enable its patches
  // (import 'kube-prometheus/kube-prometheus-anti-affinity.libsonnet') +
  // (import 'kube-prometheus/kube-prometheus-managed-cluster.libsonnet') +
  (import 'kube-prometheus/kube-prometheus-node-ports.libsonnet') +  // open Node Ports
  // (import 'kube-prometheus/kube-prometheus-static-etcd.libsonnet') +
  // (import 'kube-prometheus/kube-prometheus-thanos-sidecar.libsonnet') +
  (import 'kube-prometheus/kube-prometheus-all-namespaces.libsonnet') + // monitor all namespaces
  {
  _config+:: {
    namespace: "monitoring",

    prometheus+:: {
      replicas: 2,  // for simplicity
      // namespaces+: ["ambassador", "cicd"],  // monitor existing namespaces
    },

    alertmanager+:: {
      replicas: 1,  // for simplicity
    },

    nodeExporter+:: {
      port: 9101,  // avoid `address already in use` errors
    },
  },

//  prometheus+:: {
//    prometheus+: {
//      spec+: {
//        retention: '30d',
//        storage: {
//          volumeClaimTemplate:
//            pvc.new() +
//            pvc.mixin.spec.withAccessModes('ReadWriteOnce') +
//            pvc.mixin.spec.resources.withRequests({ storage: '50Gi' }) +
//            pvc.mixin.spec.withStorageClassName('Storage-Class-Name'),  // change
//        },
//      },
//    },
//  },

//  grafanaDashboards+:: {
//    'extra-dashboard.json': (import 'extra-dashboard.json'),
//  },
};

{ ['setup/0namespace-' + name]: kp.kubePrometheus[name] for name in std.objectFields(kp.kubePrometheus) } +
{
  ['setup/prometheus-operator-' + name]: kp.prometheusOperator[name]
  for name in std.filter((function(name) name != 'serviceMonitor'), std.objectFields(kp.prometheusOperator))
} +
// serviceMonitor is separated so that it can be created after the CRDs are ready
{ 'prometheus-operator-serviceMonitor': kp.prometheusOperator.serviceMonitor } +
{ ['node-exporter-' + name]: kp.nodeExporter[name] for name in std.objectFields(kp.nodeExporter) } +
{ ['kube-state-metrics-' + name]: kp.kubeStateMetrics[name] for name in std.objectFields(kp.kubeStateMetrics) } +
{ ['alertmanager-' + name]: kp.alertmanager[name] for name in std.objectFields(kp.alertmanager) } +
{ ['prometheus-' + name]: kp.prometheus[name] for name in std.objectFields(kp.prometheus) } +
{ ['prometheus-adapter-' + name]: kp.prometheusAdapter[name] for name in std.objectFields(kp.prometheusAdapter) } +
{ ['grafana-' + name]: kp.grafana[name] for name in std.objectFields(kp.grafana) }
