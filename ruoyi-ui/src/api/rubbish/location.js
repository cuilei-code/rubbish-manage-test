import request from '@/utils/request'

// 查询地图区位列表
export function listLocation(query) {
  return request({
    url: '/rubbish/location/list',
    method: 'get',
    params: query
  })
}

// 查询地图区位详细
export function getLocation(id) {
  return request({
    url: '/rubbish/location/' + id,
    method: 'get'
  })
}

// 新增地图区位
export function addLocation(data) {
  return request({
    url: '/rubbish/location',
    method: 'post',
    data: data
  })
}

// 修改地图区位
export function updateLocation(data) {
  return request({
    url: '/rubbish/location',
    method: 'put',
    data: data
  })
}

// 删除地图区位
export function delLocation(id) {
  return request({
    url: '/rubbish/location/' + id,
    method: 'delete'
  })
}
